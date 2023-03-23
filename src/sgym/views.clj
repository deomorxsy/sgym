(ns sgym.views
  (:require [clojure.string :as str]
            [hiccup.page :as page]
            [ring.util.anti-forgery :as util]))


(defn gen-page-head
  [title]
  [:head
   [:title (str "Locations: " title)]
   (page/include-css "/css/styles.css")])

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

(defn main [req]
   "<div>
      <h1>Hello Web Page with Routing!</h1>
      <p>What would you like to do?</p>
      <p><a href='./get-form.html'>Submit a GET request</a></p>
      <p><a href='./post-form.html'>Submit a POST request</a></p>
    </div>")


(defn post-form [req]
   "<div>
      <h1>Hello POST Form!</h1>
      <p>Submit a message with POST</p>
      <form method=\"post\" action=\"post-submit\">
       <input type=\"text\" name=\"name\" />
       <input type=\"submit\" value\"submit\" />
      </form>
      <p><a href='..'>Return to main page</p>
    </div>")

(defn not-found []
  "<h1>404 Error!</h1>
   <b>Page not found!</b>
   <p><a href='..'>Return to main page</p>")
