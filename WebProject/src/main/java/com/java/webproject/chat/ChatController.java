package com.java.webproject.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.webproject.model.RoomEntity;

@Controller
@RequestMapping("/main")
public class ChatController {

	List<RoomEntity> roomList = new ArrayList<RoomEntity>();
	static int roomNumber = 0;

	@RequestMapping("/chatting")
	public ModelAndView chat() {  // ModelAndView > 데이터와 뷰 동시에 설정 가능(Model객체와 크게 다르지 않음)
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/main/chatting"); // mv.setViewName("뷰의 경로")
		return mv; // 반환 값으로 ModelAndView 객체 반환
	}
	
	//방 페이지
	@RequestMapping("/room") 
	public void room() { 
	}
	
	//방 생성
	@RequestMapping("/createRoom") 
	public @ResponseBody List<RoomEntity> createRoom(@RequestParam HashMap<Object, Object> params) {
		String roomName = (String) params.get("roomName");
		if(roomName != null && !roomName.trim().equals("")) {
			RoomEntity room = new RoomEntity();
			room.setRoomNumber(++roomNumber);
			room.setRoomName(roomName);
			roomList.add(room);
		}
		return roomList;
	}
	
	//방 정보 가져오기 > 채팅방 리스트
	@RequestMapping("/getRoom")
	public @ResponseBody List<RoomEntity> getRoom(@RequestParam HashMap<Object, Object> params) {
		return roomList;
	}
	
	//채팅방 @return
	@RequestMapping("/moveChating") 
	public ModelAndView chating(@RequestParam HashMap<Object, Object> params) {
		ModelAndView mv = new ModelAndView();
		int roomNumber = Integer.parseInt((String) params.get("roomNumber"));
		
		List<RoomEntity> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList()); // 전달받은 파라미터값으로 방이 생성되었는지 필터함수로 체크
		if(new_list != null && new_list.size() > 0) { // 존재하는 방이면 해당 방으로 이동시켜줌
			mv.addObject("roomName", params.get("roomName")); //ModelAndView 데이터 보낼 때 addObject() 메소드 이용
			mv.addObject("roomNumber", params.get("roomNumber"));
			mv.setViewName("/main/chatting");
		}else {
			mv.setViewName("/main/room");
		}
		return mv;
	}
}
