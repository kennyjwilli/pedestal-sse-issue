(def project 'pedestal-sse-issue)
(def version "0.1-alpha1")

(set-env! :resource-paths #{"src"}
          :dependencies '[[org.clojure/clojure "1.8.0"]
                          [org.clojure/core.async "0.3.443"]
                          [org.slf4j/slf4j-nop "1.7.25"]
                          [io.pedestal/pedestal.service "0.5.3"]
                          [io.pedestal/pedestal.route "0.5.3"]
                          [io.pedestal/pedestal.jetty "0.5.3"]])

(task-options!
  pom {:project     project
       :version     version
       :description "FIXME: write description"
       :url         "http://example/FIXME"
       :scm         {:url "https://github.com/yourname/pedestal-sse-issue"}
       :license     {"Eclipse Public License"
                     "http://www.eclipse.org/legal/epl-v10.html"}})
