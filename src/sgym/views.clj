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
   [:a {:href "/warm-up"} "1. warm-up"]
   " | "
   [:a {:href "/str-training"} "2. Str training"]
   " ]"])

(defn home []
  (page/html5
   (gen-page-head "Home")
   header-links
   [:h1 "sgym home"]
   [:p "This is a static page served by Compojure.
        The changes are dynamically reloaded.<br/>
        Make sure this file is actually saved as UTF-8 encoding.
        Make sure how to check file encoding.
        English never has an encoding problem.
        However, when other languages are used, especially multi-byte
        characters, the problem often surfaces.
        If the encoding of meta tag and file's encoding are
        not the same, weird unreadable characters appear on the
        browser. Your browser may have encoding auto-detect feature
        and auto-correct outputs, though. "]))

(defn warm-up
  []
  (page/html5
   (gen-page-head "Warm-up")
   header-links
   [:h1 "Warm-up"]
   [:p "Warm-up sets lorem ipsum dolor sit amet"]))

(defn main []
  ;;[req]
  (page/html5
  (gen-page-head "main")
   [:div
      [:h1 "Hello Web Page with Routing!"]
      [:p "What would you like to do?"]
      [:p [:a {:href "./get-form.html"} "Submit a GET request"]]
      [:p [:a {:href "./post-form.html"} "Submit a POST request"]]]))


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


