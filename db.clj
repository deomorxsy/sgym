(ns sgym.db
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:import [com.mongodb MongoOptions ServerAddress]
           ;; Cheshire dependencies
		   [com.mongodb DB WriteConcern]
           [org.bson.types.ObjectId]))

;; connect using connection URI stored in an env variable, in this case, MONGODB_URL
;; stored on Github Secrets.
;; monger.core/connect-via-uri returns a map with two keys: `:conn`, `:db`
(let [uri               (System/genenv "MONGODB_URL")
      {:keys [conn db]} (mg/connect-via-uri uri)])


;; using MongoOptions allows fine-tuning connection parameters,
;; like automatic reconnection (highly recommended for production environment)
(let [^MongoOptions opts (mg/mongo-options {:threads-allowed-to-block-for-connection-multiplier 300})
      ^ServerAddress sa  (mg/server-address "127.0.0.1" 27017)
      conn               (mg/connect sa opts)]
  )


(defn save-id)
