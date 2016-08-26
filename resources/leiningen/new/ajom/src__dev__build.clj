(ns build
  (:require [shadow.cljs.build :as cljs]
            [shadow.cljs.umd :as umd]
            [shadow.devtools.server :as devtools]
            [clojure.java.io :as io]))

(defn- plugin-setup []
  (-> (cljs/init-state)
      (cljs/set-build-options
          {:node-global-prefix "global.{{sanitized}}"})
      (cljs/find-resources-in-classpath)
      (umd/create-module
        {:activate '{{raw-name}}.core/activate
         :serialize '{{raw-name}}.core/serialize
         :deactivate '{{raw-name}}.core/deactivate}
        {:output-to "plugin/lib/{{raw-name}}.js"})))

(defn release []
  (-> (plugin-setup)
      (cljs/compile-modules)
      (cljs/closure-optimize :simple)
      (umd/flush-module))
  :done)

(defn dev []
  (-> (plugin-setup)
      (cljs/watch-and-repeat!
        (fn [state modified]
          (-> state
              (cljs/compile-modules)
              (umd/flush-unoptimized-module))))))

(defn dev-once []
  (-> (plugin-setup)
      (cljs/compile-modules)
      (umd/flush-unoptimized-module))
  :done)

(defn dev-repl []
  (-> (plugin-setup)
      (devtools/start-loop
        {:before-load '{{raw-name}}.core/stop
         :after-load '{{raw-name}}.core/start
         :reload-with-state true
         :console-support true
         :node-eval true}
        (fn [state modified]
          (-> state
              (cljs/compile-modules)
              (umd/flush-unoptimized-module)))))

  :done)
