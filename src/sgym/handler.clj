;;handler: a function that takes a request map and returns a response.

(ns sgym.handler
  (:require [compojure.core :refer [context defroutes GET POST PUT DELETE ANY]]
            [ring.util.response :as resp]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.core :as hiccup]
            [sgym.views :as views]
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
  (GET "/main"        [] (views/main))
  (GET "/get-form.html"    [req] (views/get-form req))
  (GET "/post-form.html"   [req] (views/post-form req))
  (GET "/get-submit"  [req] (views/display-result req))
  ;; route action that processes the form-data
  (POST "/post-submit" [req] (views/display-result req))
  (POST "/str-training" {params :params})
  ;;route/resources "/helloworld")
  ;;(route/not-found "/4dsadasdas")
  (GET "/not-found" [req] (views/not-found req))
  (context "/new-plan" []
            (GET "/" [] (views/new-plan))
            (GET "/warm-up" [] (views/warm-up))
            (GET "/strength" [] (views/strength))
            (GET "/cardio" [] (views/cardio))
            (GET "/cool" [] (views/cool))
    ))


;;(defroutes user-routes
;;  (context "/new-plan" []
;;   (GET "/" [] (views/new-plan))
;;   (GET "/warm-up" [] (views/warm-up))
   ;;(GET "/strength" [] (strength))
   ;;(GET "/cardio" [] (views/cardio))
   ;;(GET "/cool" [] (views/cool))
  ;;))

(def app
  (wrap-defaults app-routes site-defaults))
