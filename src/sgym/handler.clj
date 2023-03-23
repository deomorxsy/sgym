;;handler: a function that takes a request map and returns a response.

(ns sgym.handler
  (:require [compojure.core :refer [defroutes GET POST]]
            [ring.util.response :as resp]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [hiccup.core :as hiccup]
            [sgym.views :as views]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

;; rendering from html file instead of views (which uses hiccup)
(defroutes app-routes
  (GET "/" []
       ;;(resp/content-type (resp/resource-response "001-helloworld.html" {:root "public"}) "text/html")
       (views/home))
  (GET "/warm-up"
    []
    ;;(resp/content-type (resp/resource-response "01-warm-up.html" {:root "public"}) "text/html")
    (views/warm-up))
  (GET "/main"
    []
    (views/main))

  (POST "/str-training"
    {params :params}
   ;;(resp/content-type (resp/resource-response "02-str-training.html" {:root "public"}) "text/html")
	)

  (route/resources "/helloworld")
  (route/not-found "Not Found"))


(def app
  (wrap-defaults app-routes site-defaults))
