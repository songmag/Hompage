const fs = require('fs');
const chat_config = require('./api/config');
const chat_api = require('./api/api_module');
const http = require('http').createServer((req,res)=>{
    res.writeHead(200,chat_config.server_option.healthHeader);
    res.end('http1 번에 접속'+JSON.stringify(req.method));
});
const http2 = require('http').createServer((req,res)=>{
    let html = /(\/+\w*)*.html$|(\/+\w*)*.jsp$/g.test(req.url)
    if(req.method != 'get' && !html){
        res.end();
        return;
    }
    let chat_server = 'face-trip.com:9999/';
    if(req.headers.host.indexOf('localhost')> -1){
        chat_server = 'localhost:9999/';
    }
    if(req.url){
       fs.readFile('./html'+req.url,'UTF-8',function(err,file){
           file = file.replace(/CHAT_SERVER/g,chat_server);
           res.write(file);
           res.end();
       });
    }
    res.writeHead(200,chat_config.server_option.healthHeader);
});


http2.listen(9898);
http.listen(chat_config.server_option.port);
const io = require('socket.io')(http,chat_config.chat_server_option);
const chat_view = io.of(chat_config.chat_option.name);
const chat_alarm = io.of(chat_config.chat_alarm_option.name);
chat_view.on('connection',(socket)=>{
    chat_api.functions(socket);
});
chat_alarm.on('connection',(socket)=>{
    chat_api.functions(socket);
});


