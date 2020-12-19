module.exports.functions = {
    pre_connect : (socket, user_infm)=>{

    },
    connect : (socket,room_no,user_id)=>{
        let msg= {
            user_id : user_id,
            msg : 'connect'
        }
        socket.to(room_no).emit(msg);
    },
    sendMessage : (socket, room_no,msg)=>{
        socket.to(room_no).emit(msg);
    }
}