# pedestal-sse-issue

FIXME: description

## Usage

Open a REPL and run `pedestal-sse-issue.core/start`. This starts the Pedestal server on port 8080.
Open up `index.html` in the `public` directory in Chrome. In the devtools console you should see the Event
message being printed. It will look something like this: 

```
MessageEvent {isTrusted: true, data: "[B@6e42357", origin: "http://localhost:8080", lastEventId: "", source: null…}
```

As you can see, the `data` field is `"[B@6e42357"`. It should be deserialized JSON. It looks a whole lot like how 
Clojure prints out Byte arrays. Is Pedestal incorrectly serializing SSE messages?