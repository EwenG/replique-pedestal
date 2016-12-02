(ns replique-pedestal.core
  (:require [io.pedestal.http.route.definition :refer [defroutes]]
            [io.pedestal.http.route :as route]
            [io.pedestal.http :as http]
            [io.pedestal.interceptor.helpers :refer [defhandler]]))

(defhandler index [request]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "<html>
<head>
</head>
<body>
<p>Welcome to replique-pedestal. This is a demo of using Replique in a web application context.</p>
<script src=\"/main.js\"></script>
</body>
</html>"})

(defroutes routes
  [[["/" {:get index}]]])

(def url-for  (route/url-for-routes routes))

(def server-conf {::http/routes #(deref #'routes)
                  ::http/resource-path "/public"
                  ::http/type :immutant
                  ::http/port 8080})

(defonce server (http/create-server server-conf))

(comment

  (http/start server)
  (http/stop server)

  )
