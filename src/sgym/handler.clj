;;handler: a function that takes a request map and returns a response.

(ns sgym.handler
  (:require [compojure.core :refer [defroutes GET POST PUT DELETE ANY]]
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
  (GET "/warm-up"     [] (views/warm-up))
  (GET "/main"        [] (views/main))
  (GET "/get-form.html"    [req] (views/get-form req))
  (GET "/post-form.html"   [req] (views/post-form req))
  (GET "/get-submit"  [req] (views/display-result req))
  (POST "/post-submit" [req] (views/display-result req))
  (POST "/str-training" {params :params})
  (route/resources "/helloworld")
  (route/not-found "Not Found"))


(def app
  (wrap-defaults app-routes site-defaults))
