(ns sgym.mongo.db
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [monger.json])
  (:import [com.mongodb MongoOptions ServerAddress]))
;; connect using connection URI stored in an env variable, in this case, MONGODB_URL
;; stored on Github Secrets.
;; monger.core/connect-via-uri returns a map with two keys: `:conn`, `:db`
(let [uri               (System/genenv "MONGODB_URL")
      {:keys [conn db]} (mg/connect-via-uri uri)])


;;(defn save-id)
