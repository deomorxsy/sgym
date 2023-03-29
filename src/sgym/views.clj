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

(defn str-training
  []
  (page/html5
   (gen-page-head "sgym: warm-up")
    [:div
     [:h1 "WARM-UP"]]))

(defn warm-up
  []
  (page/html5
   (gen-page-head "sgym: warm-up")
    [:div
     [:h1 "WARM-UP"]
     [:form {:method "get" :action "get-submit"}
      [:ul [:li
       [:label {:for "msg"} "Activity:"]
       [:input {:type "text" :name "get-submit"}]
       [:input {:type "submit" :value "submit"}]
      ]]
     ]

     [:form {:method "get" :action "get-submit"}
      [:ul [:li
       [:label {:for "msg"} "Time/Dist:"]
       [:input {:type "text" :name "get-submit"}]
       [:input {:type "submit" :value "submit"}]
      ]]
     ]

     [:form {:method "get" :action "get-submit"}
      [:ul [:li
      [:label {:for "msg"} "Sets/Reps:"]
       [:input {:type "text" :name "get-submit"}]
       [:input {:type "submit" :value "submit"}]
       ]]
     ]

     [:form {:method "get" :action "get-submit"}
      [:ul [:li
       [:label {:for "msg"} "Intensity:"]
       [:input {:type "text" :name "get-submit"}]
       [:input {:type "submit" :value "submit"}]
      ]]
     ]

     [:form {:method "get" :action "get-submit"}
      [:ul [:li
      [:label {:for "msg"} "Notes:"]
      [:input {:type "text" :name "get-submit"}]
      [:input {:type "submit" :value "submit"}]
      ]]
      ]
     ]
     [:p [:a {:href "/main"} "Return to main page!"]]
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
      [:p [:a {:href "/new-plan/warm-up"} "1. Warm-up"]]
      [:p [:a {:href "/new-plan/str"} "2. Strength training"]]
      [:p [:a {:href "/new-plan/cardio"} "3. Cardio training"]]
      [:p [:a {:href "/warm-up/cool"} "4. Cool down"]]
     ]]
   ]))


(defn get-form [req]
  ;;[req]
  (page/html5
  (gen-page-head "gf-style")
    [:div
     [:h1 "Hello GET form!"]
     [:p "Submit a message with GET"]
     [:form {:method "get" :action "get-submit"}
      [:input {:type "text" :name "get-submit"}]
      [:input {:type "submit" :value "submit"}]
     [:p [:a {:href "/main"} "Return to main page!"]]
      ]]
    ))

(defn post-form [req]
  ;;[req]
  (page/html5
  (gen-page-head "pf-style")
   [:div
      [:h1 "Hello POST Form!"]
      [:p "Submit a message with POST"]
      ;; action sends the form-data to a file (URL URI)
      ;; named "post-submit", processing the input
      [:form {:method "post" :action "post-submit"}
       [:input {:type "text"} {:name "name"}]
       [:input {:type "submit"} {:value "submit"}]]
      [:p [:a {:href ".."} "Return to main page"]]]))

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


