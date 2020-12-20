const chat_config = require('./api/config');
const http = require('http').createServer((req,res)=>{
    res.writeHead(200,chat_config.server_option.healthHeader);
    res.end('http1 번에 접속'+JSON.stringify(req.method));
});

const http2 = require('http').createServer((req,res)=>{
    let chat_server = 'face-trip.com:9999/';
    if(req.headers.host.indexOf('localhost')> -1){
        chat_server = 'localhost:9999/';
    }
    let socket = '<script>var socket = io.connect("ws://'+chat_server+'",{credentials : true,reconnection : true,path :"/chat" } );</script>'
    res.writeHead(200,chat_config.server_option.healthHeader);
    res.write('<script src="https://cdnjs.cloudflare.com/ajax/libs/socket.io/3.0.1/socket.io.min.js"></script>');
    res.write(socket);
    res.end('http2 번에 접속');
});


http2.listen(9898);
http.listen(chat_config.server_option.port);
const io = require('socket.io');
const socketIo = io.of(http,chat_config.chat_option);
socketIo.use((socket,next)=>{
    next();
});
socketIo.on('connection',(socket)=>{

});


