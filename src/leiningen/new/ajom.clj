(ns leiningen.new.ajom
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "ajom"))

(defn ajom
  "FIXME: write documentation"
  [name]
  (let [data {:raw-name name
              :name name
              :sanitized (name-to-path name)}]
    (main/info "Generating new ajom project.")
    (->files data
             ["README.md" (render "README.md" data)]
             [".gitignore" (render ".gitignore")]
             ["project.clj" (render "project.clj" data)]
             ["plugin/keymaps/{{raw-name}}.cson" (render "plugin__keymaps__keymap.cson" data)]
             ["plugin/menus/{{raw-name}}.cson" (render "plugin__menus__menu.cson" data)]
             ["plugin/package.json" (render "plugin__package.json" data)]
             ["plugin/styles/{{raw-name}}.less" (render "plugin__styles__style.less" data)]
             ["src/{{sanitized}}/core.cljs" (render "src__core.cljs" data)])))
