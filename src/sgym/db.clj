(ns sgym.mongo.db
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [monger.json])
  (:import [com.mongodb MongoOptions ServerAddress]))
;; connect using connection URI stored in an env variable, in this case, MONGODB_URL
;; stored on Github Secrets.
;; monger.core/connect-via-uri returns a map with two keys: `:conn`, `:db`
;; Accessible via environment variable bootstrapped by Github Secrets
(let [uri               (System/getenv "MONGODB_URL")
      {:keys [conn db]} (mg/connect-via-uri uri)]
      
      ;;Insert
      ;;(mc/insert db coll {:exercise :key[exercise]  :sets :key[reps] :weight :key[weight] :rest :key[rest] :notes :key[notes]})
      ;;(mc/insert db coll {:first_name "Ringo" :last_name "Starr"})

      ;;Find
      ;;(mc/find db coll {:first_name "Ringo"}))

      )


;;(defn save-id)
