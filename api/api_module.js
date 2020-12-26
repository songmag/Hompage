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
            this.to(rooms).emit('read message',user_infm);
        }
    }
    catch{
        console.log(user_infm + " 에러 :: \n");
    }
}
//방에 메세지 전송
/**
 * 다른 네임스페이스에 값을 전달 할 수 있는 방법이 무엇인가?
 * 네임 스페이스 값을 가지고 있는다?
 * @param send_data
 */
function send_message(send_data){
    try{
        this.server.of('/chat_view').to(send_data.rooms).emit('receive_message',send_data);
        this.to(send_data.rooms).emit('receive_message',send_data);
    }
    catch{
        console.log('\n'+ send_data + " 에러 !! \n");
    }
}

function join_room(send_data){
    try{
        this.to(send_data.rooms).emit('join_room',send_data);
    }catch{
        console.log('\n 방 참여 에러');
    }
}

