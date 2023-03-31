;;handler: a function that takes a request map and returns a response.

(ns sgym.handler
  (:require [compojure.core :refer [context defroutes GET POST PUT DELETE ANY]]
            [ring.util.response :as resp]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.core :as hiccup]
            [sgym.views :as views]
            ;;[sgym.db :refer [get-all get-by-id save-id]]
            [sgym.db :as db]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.keyword-params :as rmkp]
            [ring.middleware.params :as rmp]))

;; rendering from html file instead of views (which uses hiccup)

(defroutes app-routes
  (GET "/"        []
       ;;(resp/content-type (resp/resource-response "001-helloworld.html" {:root "public"}) "text/html")
                     (views/home))
  (GET "/new-plan"    [] (views/new-plan))
  ;;(GET "/warm-up"     [] (views/warm-up))
  ;; (GET "/main"        [] (views/main))
  ;; (GET "/get-form.html"    [req] (views/get-form req))
  ;; (GET "/post-form.html"   [req] (views/post-form req))
  (GET "/get-submit"  [req] (views/display-result req))
  ;; route action that processes the form-data
  (POST "/post-submit" [req] (views/display-result req))
  (POST "/str-training" {params :params})
  ;;route/resources "/helloworld")
  ;;(route/not-found "/4dsadasdas")
  (GET "/not-found" [req] (views/not-found req))
  ;; (GET "/new-plan/warm-up" [] ())
(POST "/warm-up"  {params :params} (views/post-warm-up params))
(POST "/strength"  {params :params} (views/post-strength params))
(POST "/cardio"  {params :params} (views/post-cardio params))
(POST "/cool"  {params :params} (views/post-cool params))
  (context "/new-plan" []
            (GET "/" [] (views/new-plan))
            (GET "/warm-up" [] (views/warm-up))
            (GET "/strength" [] (views/strength))
            (GET "/cardio" [] (views/cardio))
            (GET "/cool" [] (views/cool))
    ))

(def app
  ;;(wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
   (wrap-defaults app-routes site-defaults))


