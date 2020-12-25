module.exports.functions = socket => {
    socket.on('pre_connection', pre_connection);
    socket.on('send_message',send_message);
    socket.on('join_room',join_room);
}
function pre_connection(user_infm){
    try {
        let rooms = user_infm.rooms;
        let user_id = user_infm.user_id;
        this.join(rooms);
        if(!(rooms instanceof Array)){
            this.of(rooms).emit('read message',user_infm);
        }
    }
    catch{
        console.log(user_infm + " 에러 :: \n");
    }
}
//방에 메세지 전송
function send_message(send_data){
    try{
        this.of(send_data.rooms).emit('recive_message',send_data);
    }
    catch{
        console.log('\n'+ send_data + " 에러 !! \n");
    }
}
function join_room(send_data){
    try{
        this.of(send_data.rooms).emit('join_room',send_data);
    }catch{

    }
}

