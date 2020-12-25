let cors = {
    origins : ['http://localhost:9898','http://face-trip.com:9898'],
    methods : ['GET','POST'],
    credentials : true,
}

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
    name : '/chat_view'
};
module.exports.chat_alarm_option = {
    name : '/chat_alarm'
};
module.exports.chat_server_option = {
    cors : cors,
    path : '/node'
}
