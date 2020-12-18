module.exports.server_option = {
        port: 9999,
        healthHeader : {
            "Content-Type": "text/html; charset=utf-8",
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET,POST",
            "Access-Control-Allow-Credentials": true
        }
    };
module.exports.chat_option =  {
        cors : {
            origins : ['http://localhost:9898','http://face-trip.com:9898'],
            methods : ['GET','POST'],
            credentials : true,
        },
        path : '/chat'
    };