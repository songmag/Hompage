const chat_socket_list = [];
class chat_api{
    #socket;
    #roomSrno = [];
    constructor(socket) {
        this.#socket  = socket;
        chat_socket_list.push(this);
    }
    connect(userid){
        //userID 를 통해서 room chat rsno 를 가져온다.
    }
    havingRoomSrno(msg){
        let rs = false;
        if(msg.roomSrno){
            for(let i = 0 ; i < this.#roomSrno ; i++){
                if(this.#roomSrno[i] == msg.roomSrno){
                    rs = true;
                    break;
                }
            }
            return rs;
        }
    }
    sendMessage(msg){
        this.#socket.send(msg);
    }
}
