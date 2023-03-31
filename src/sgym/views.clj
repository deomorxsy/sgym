(ns sgym.views
  (:require [clojure.string :as str]
            [hiccup.core :refer [html h]]
            [hiccup.page :as page]
            [ring.util.anti-forgery :as util]))


(defn gen-page-head
  [title]
  [:head
   [:title (str "Locations: " title)]
   ;;(page/include-css "/css/styles.css")
   (page/include-css "/css/main.css")])

(def header-links
  [:div#header-links
   "[ "
   [:a {:href "/"} "Home"]
   " | "
   [:a {:href "/new-plan"} "New Plan"]
   " ]"]
    )

(defn home []
  (page/html5
   (gen-page-head "Home")
   header-links
   [:h1 "sgym"]
   [:p "Welcome to our premier gym, where fitness and
        health meet. We offer state-of-the-art equipment,
        a clean and spacious facility, and expert trainers
        who are dedicated to helping you achieve your fitness
        goals. Whether you're a beginner or a seasoned athlete,
        our supportive community and personalized approach will
        help you get the results you want. Come in today and
        experience the energy and motivation of our gym.
        Let's work together to transform your body and
        your life. "]))



  (defn cool
  []
  (page/html5
   (gen-page-head "sgym: Cool down")
    [:div
     [:h1 "Cool down"]
     [:form {:method "POST" :action "/cool"}
      [:ul [:li
       [:label {:for "exercise"} "Exercises"]
        [:input {:type "text" :name "exercise"}]
        [:label {:for "time"} "Time/Dist"]
        [:input {:type "text" :name "time"}]
        [:label {:for "reps"} "Sets/Reps:"]
        [:input {:type "text" :name "reps" :id "reps"}]
        [:label {:for "intensity"} "Intensity"]
        [:input {:type "text" :name "intensity"}]
        [:label {:for "notes"} "Notes:"]
        [:input {:type "text" :name "notes"}]
        [:input {:type "submit" :value "submit"}]
      ]]
     ]
    ]
     [:p [:a {:href "/"} "Return to main page!"]]
    ))

(defn post-cool 
  [{:keys [exercise time reps intensity notes]}]
    (page/html5
    (gen-page-head "Form Submitted")
      [:div
      [:h1 "Form Submitted"]
      [:p "You submitted the following:"]
      [:ul [:li
        [:label {:for "msg"} exercise]
        [:label {:for "msg"} time]
        [:label {:for "msg"} reps]
        [:label {:for "msg"} intensity]
        [:label {:for "msg"} notes]
      ]]
      ]
      [:p [:a {:href "/"} "Return to main page!"]]
      ))

 (defn cardio
  []
  (page/html5
   (gen-page-head "sgym: Cardio")
    [:div
     [:h1 "Cardio"]
     [:form {:method "POST" :action "/cardio"}
      [:ul [:li
        [:label {:for "exercise"} "Exercises"]
        [:input {:type "text" :name "exercise"}]
        [:label {:for "time"} "Time/Dist"]
        [:input {:type "text" :name "time"}]
        [:label {:for "target"} "Target HR"]
        [:input {:type "text" :name "target"}]
        [:label {:for "intensity"} "Intensity"]
        [:input {:type "text" :name "intensity"}]
        [:label {:for "notes"} "Notes:"]
        [:input {:type "text" :name "notes" :id "notes"}]
        [:input {:type "submit" :value "submit"}]
      ]]
     ]
    ]
     [:p [:a {:href "/"} "Return to main page!"]]
    ))

(defn post-cardio 
[{:keys [exercise time target intensity notes]}]
  (page/html5
   (gen-page-head "Form Submitted")
    [:div
     [:h1 "Form Submitted"]
     [:p "You submitted the following:"]
     [:ul [:li
      [:label {:for "msg"} exercise]
      [:label {:for "msg"} time]
      [:label {:for "msg"} target]
      [:label {:for "msg"} intensity]
      [:label {:for "msg"} notes]
     ]]
    ]
    [:p [:a {:href "/"} "Return to main page!"]]
    ))

 (defn strength
  []
  (page/html5
   (gen-page-head "sgym: Strength training")
    [:div
     [:h1 "Strength Training"]
     [:form {:method "POST" :action "/strength"}
      [:ul [:li
      [:label {:for "exercise"} "Exercise:"]
      [:input {:type "text" :name "exercise" :id "exercise"}]
      [:label {:for "sets"} "Sets:"]
      [:input {:type "text" :name "sets" :id "sets"}]
      [:label {:for "reps"} "Sets/Reps:"]
      [:input {:type "text" :name "reps" :id "reps"}]
      [:label {:for "weight"} "Weight:"]
      [:input {:type "text" :name "weight" :id "weight"}]
      [:label {:for "rest"} "Rest:"]
      [:input {:type "text" :name "rest" :id "rest"}]
      [:label {:for "notes"} "Notes:"]
      [:input {:type "text" :name "notes" :id "notes"}]
      [:input {:type "submit" :value "submit"}]
      ]]
     ]
     ]
     [:p [:a {:href "/"} "Return to main page!"]]
    ))

(defn post-strength 
[{:keys [exercise sets reps weight rest notes]}]
  (page/html5
   (gen-page-head "Form Submitted")
    [:div
     [:h1 "Form Submitted"]
     [:p "You submitted the following:"]
     [:ul [:li
      [:label {:for "msg"} exercise]
      [:label {:for "msg"} sets]
      [:label {:for "msg"} reps]
      [:label {:for "msg"} weight]
      [:label {:for "msg"} rest]
      [:label {:for "msg"} notes]
     ]]
    ]
    [:p [:a {:href "/"} "Return to main page!"]]
    ))

(defn warm-up
  []
  (page/html5
   (gen-page-head "sgym: warm-up")
    [:div
     [:h1 "WARM-UP"]
      [:form {:method "POST" :action "/warm-up" :id "warmUpForm"}
      [:ul [:li
        [:label {:for "activity"} "Activity:"]
        [:input {:type "text" :name "activity" :id "activity"}]
        [:label {:for "timeDist"} "Time/Dist:"]
        [:input {:type "text" :name "timeDist" :id "timeDist"}]
        [:label {:for "sets"} "Sets/Reps:"]
        [:input {:type "text" :name "sets" :id "sets"}]
        [:label {:for "notes"} "Notes:"]
        [:input {:type "text" :name "notes" :id "notes"}]
        [:label {:for "intensity"} "Intensity:"]
        [:input {:type "text" :name "intensity" :id "intensity"}]
        [:input {:type "submit" :value "submit"}]
      ]]
     ]
    ]
    [:p [:a {:href "/"} "Return to main page!"]]
    ))


(defn post-warm-up 
[{:keys [activity timeDist sets notes intensity]}]
  (page/html5
   (gen-page-head "Form Submitted")
    [:div
     [:h1 "Form Submitted"]
     [:p "You submitted the following:"]
     [:ul [:li
      [:label {:for "msg"} activity]
      [:label {:for "msg"} timeDist]
      [:label {:for "msg"} sets]
      [:label {:for "msg"} notes]
      [:label {:for "msg"} intensity]
     ]]
    ]
    [:p [:a {:href "/"} "Return to main page!"]]
    ))

(defn main []
  ;;[req]
  (page/html5
  (gen-page-head "main")
   [:div
      [:h1 "Hello Web Page with Routing!"]
      [:p "What would you like to do?"]
      [:p [:a {:href "./get-form.html"} "Submit a GET request"]]
      [:p [:a {:href "./post-form.html"} "Submit a POST request"]]]))

(defn new-plan []
  ;; [req]
  (page/html5
  (gen-page-head "New Plan")
   [:div
    [:h1 "Weekly Plan"]
     [:ul [:li
      [:p [:a {:href "/new-plan/warm-up"} "1. Warm up"]]
      [:p [:a {:href "/new-plan/strength"} "2. Strength training"]]
      [:p [:a {:href "/new-plan/cardio"} "3. Cardio training"]]
      [:p [:a {:href "/new-plan/cool"} "4. Cool down"]]
     ]]
   ]))


;; (defn get-form [req]
;;   ;;[req]
;;   (page/html5
;;   (gen-page-head "gf-style")
;;     [:div
;;      [:h1 "Hello GET form!"]
;;      [:p "Submit a message with GET"]
;;      [:form {:method "get" :action "get-submit"}
;;       [:input {:type "text" :name "get-submit"}]
;;       [:input {:type "submit" :value "submit"}]
;;      [:p [:a {:href "/main"} "Return to main page!"]]
;;       ]]
;;     ))

;; (defn post-form [req]
;;   ;;[req]
;;   (page/html5
;;   (gen-page-head "pf-style")
;;    [:div
;;       [:h1 "Hello POST Form!"]
;;       [:p "Submit a message with POST"]
;;       ;; action sends the form-data to a file (URL URI)
;;       ;; named "post-submit", processing the input
;;       [:form {:method "post" :action "post-submit"}
;;        [:input {:type "text"} {:name "name"}]
;;        [:input {:type "submit"} {:value "submit"}]]
;;       [:p [:a {:href ".."} "Return to main page"]]]))

(defn not-found [req]
  (page/html5
  (gen-page-head "nunca nem vi")
  [:h1 "404 Error!"]
  [:b "Page not found!"]
  [:b [:a {:href=".."} "Return to main page"]]))

(defn display-result [req]
  (let [{:keys [params uri]} req
        param-name (get params "name")
        req-type (if (= uri "get-submit") "GET" "POST")]
    (page/html5
      [:div
          [:h1 "Hello " (h param-name) "!"]
          [:p "Submitted via a" req-type " request"]
          [:p [:a {:href="/main"} "Return to main page"]]])))
