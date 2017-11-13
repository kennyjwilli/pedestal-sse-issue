(ns pedestal-sse-issue.core
  (:require
    [clojure.core.async :as async]
    [io.pedestal.http :as http]
    [io.pedestal.http.route :as route]
    [io.pedestal.http.sse :as sse]))

(defn subscribe-stream-ready
  [event-chan ctx]
  (async/go-loop []
    (async/<! (async/timeout 1000))
    (sse/send-event event-chan "example" "test")
    (recur)))

(def routes
  #{["/subscribe" :get [(sse/start-event-stream subscribe-stream-ready)] :route-name :subscribe]})

(def service-map
  (-> {::http/type            :jetty
       ::http/port            8080
       ::http/join?           false
       ::http/routes          #(route/expand-routes (deref #'routes))
       ::http/allowed-origins {:allowed-origins (constantly true)
                               :creds           true}}
      (http/default-interceptors)
      (http/dev-interceptors)))

(defonce server (atom nil))

(defn start
  []
  (reset! server (http/start (http/create-server service-map))))

(defn stop
  []
  (http/stop @server))

(defn restart
  []
  (stop)
  (start))