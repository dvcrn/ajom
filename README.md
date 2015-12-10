# ajom

A leiningen template for atom plugins in clojurescript with code live-reload

## Usage

[![Clojars Project](http://clojars.org/ajom/lein-template/latest-version.svg)](http://clojars.org/ajom/lein-template)

```
lein new ajom {{project-name}}
```

## Compiling and running

To compile me with a self-reloading loop, use:

```
lein run -m build/dev-repl
```

To compile for release, use
```
lein run -m build/release
```

After you have done that, go into the `plugin/` folder and run
```
apm link
```

Your plugin should now be installed inside atom.


## Development

If you want to export a function to atom for use with atom commands, make sure to add them to `dev/build.clj` like so:
```
:foo 'your-thing.core/foo
:bar 'your-thing.core/bar
```

## License

Copyright (c) 2015 David Mohl

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
