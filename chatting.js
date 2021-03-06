
const option = {
    port: 9999,
}
const healthHeader = {
    "Content-Type":"text/html; charset=utf-8",
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET,POST",
    "Access-Control-Allow-Credentials": true
}
const http = require('http').createServer((req,res)=>{
    res.writeHead(200,healthHeader);
    res.end('http1 번에 접속'+JSON.stringify(req.method));
});
const http2 = require('http').createServer((req,res)=>{
    res.writeHead(200,healthHeader);
    res.write('<script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/3.0.1/socket.io.min.js"></script>');
    res.write('<script>var socket = io.connect("ws://localhost:9999/",{credentials : true,reconnection : true,path :"/chat" } );</script>');
    res.end('http2 번에 접속');
});
http2.listen(9898);
http.listen(option.port);
const chat_opt= {
    cors : {
        origin : 'http://localhost:9898',
        methods : ['GET','POST'],
        credentials : true,
    },
    path : '/chat'
}
const io = require('socket.io');
const socketIo = io(http,chat_opt);
socketIo.on('connection',(socket)=>{
    console.log("connection 서버");
})

