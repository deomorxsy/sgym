;; ring middleware prototype
(ns sgym.middleware
  (:require [ring.middleware.params :as rmp]
            [ring.middleware :as rmkp])
  (rmp/wrap-parameters handler-fn))


(defn middleware-fn
    [handler-fn]
    (fn [request]
      ;;operations on the request
      ;; create new, log, etc
      (let [new-response (handler-fn new-request)]
        ;;
        ;;
        new-and-modified-response)))
