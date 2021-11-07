package controller.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import model.chat.ChatService;
import model.chat.ChatVO;
import model.member.MemberVO;
import model.page.PageService;
import model.page.PageVO;
import model.room.RoomService;
import model.room.RoomVO;

@Controller
@SessionAttributes("user")
public class RoomController {
	@Autowired
	private RoomService roomService;	

	@Autowired
	private ChatService chatService;

	@Autowired
	private PageService pageService;


	@RequestMapping("/main.do")
	public String main(RoomVO rvo,PageVO pvo, Model model, @RequestParam(value="page",defaultValue="1")int page) {
		pvo.setCurPage(page);	//	현재 페이지	
		pvo.setPerPage(4);		//	페이지 게시물 수
		pvo.setPerPageSet(5);	//	페이지 수

		pvo = pageService.paging(pvo);
		model.addAttribute("rdatas",roomService.rSelectAll(pvo));
		model.addAttribute("paging",pvo);
		model.addAttribute("page", page);
		return "main.jsp";
	}

	@RequestMapping("/myroom.do")
	public String myroom(RoomVO rvo,PageVO pvo, Model model, @ModelAttribute("user")MemberVO mvo, @RequestParam(value="page",defaultValue="1")int page) {
		System.out.println(mvo);
		pvo.setEmail(mvo.getEmail());
		pvo.setType("my");
		pvo.setCurPage(page);	//	현재 페이지	
		pvo.setPerPage(4);		//	페이지 게시물 수
		pvo.setPerPageSet(5);	//	페이지 수

		pvo = pageService.paging(pvo);
		model.addAttribute("rdatas",roomService.rSelectAll(pvo));
		model.addAttribute("paging",pvo);
		model.addAttribute("page", page);
		return "myroom.jsp";
	}


	@RequestMapping("/room.do")
	public String room(ChatVO cvo,RoomVO rvo, Model model) {
		RoomVO data = roomService.rSelectOne(rvo);
		if(data == null) {		
			return "redirect:main.do";
		}
		else {
			model.addAttribute("cdatas",chatService.cSelectAll(cvo));
			return "room.jsp";
		}
	}


	@RequestMapping(value="/rform.do", method=RequestMethod.POST)
	public String rformEdit(RoomVO vo,Model model) {
		RoomVO data = roomService.rSelectOne(vo);
		if(data == null) {
			return "redirect:myroom.do";
		}
		else {			
			model.addAttribute("rdata",data);
			return "rform.jsp";
		}
	}

	@RequestMapping(value="/rform.do", method=RequestMethod.GET)
	public String rform(RoomVO vo,Model model) {
		return "redirect:rform.jsp";
	}

	@RequestMapping("/rinsert.do")
	public String rinsert(HttpServletRequest request, RoomVO vo) throws IllegalStateException, IOException {
		String savedir = request.getSession().getServletContext().getRealPath("images");
		System.out.println(savedir);
		MultipartFile fileupload = vo.getFileupload();
		if(!fileupload.isEmpty()) {
			vo.setFilepath(UUID.randomUUID().toString()+fileupload.getOriginalFilename());
			fileupload.transferTo(new File(savedir+"/"+vo.getFilepath()));
		}

		if(roomService.rInsert(vo)) {
			return "redirect:myroom.do";
		}
		else {
			if(vo.getFilepath() != null || vo.getFilepath() =="") {
				File file = new File(savedir+"/"+vo.getFilepath());
				if(file.exists()) {
					file.delete();
				}
			}
			return "redirect:rform.jsp";
		}


	}

	@RequestMapping("/rdelete.do")
	public String rdelete(HttpServletRequest request, RoomVO vo) {
		String savedir = request.getSession().getServletContext().getRealPath("images");
		File file = new File(savedir+"/"+vo.getFilepath());
		if(roomService.rDelete(vo)) {
			if(vo.getFilepath() != null || vo.getFilepath() =="") {
				if(file.exists()) {
					file.delete();
				}
			}
		}
		return "redirect:myroom.do";
	}

	@RequestMapping("/rupdate.do")
	public String rupdate(HttpServletRequest request, RoomVO vo) throws IllegalStateException, IOException {
		String savedir = request.getSession().getServletContext().getRealPath("images");		
		MultipartFile fileupload =vo.getFileupload();

		if(!fileupload.isEmpty()) {
			if(vo.getFilepath() != null || vo.getFilepath() =="") {
				File prefile = new File(savedir+"/"+vo.getFilepath());
				if(prefile.exists()) {
					prefile.delete();
				}
				vo.setFilepath(UUID.randomUUID().toString()+fileupload.getOriginalFilename());
				fileupload.transferTo(new File(savedir+"/"+vo.getFilepath()));

			}


		}
		if(roomService.rUpdate(vo)) {
			return "redirect:myroom.do";
		}
		else {
			if(vo.getFilepath() != null || vo.getFilepath() =="") {
				File file = new File(savedir+"/"+vo.getFilepath());
				if(file.exists()) {
					file.delete();
				}
			}
			return "redirect:myroom.do";
		}
	}

	@RequestMapping("/chatlog.do")
	public void chatlog(ChatVO vo, HttpServletResponse response) throws IOException {
		List<ChatVO> datas = chatService.cSelectAll(vo);

		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("chatlog");
		Row row = null;
		Cell cell = null;
		int rowNo = 0;

		CellStyle headStyle = wb.createCellStyle();
		headStyle.setBorderTop(BorderStyle.THIN);
		headStyle.setBorderBottom(BorderStyle.THIN);
		headStyle.setBorderLeft(BorderStyle.THIN);
		headStyle.setBorderRight(BorderStyle.THIN);

		CellStyle bodyStyle = wb.createCellStyle();
		bodyStyle.setBorderTop(BorderStyle.THIN);
		bodyStyle.setBorderBottom(BorderStyle.THIN);
		bodyStyle.setBorderLeft(BorderStyle.THIN);
		bodyStyle.setBorderRight(BorderStyle.THIN);



		row = sheet.createRow(rowNo++);

		cell = row.createCell(0);
		cell.setCellStyle(headStyle);
		cell.setCellValue("timeline");
		cell = row.createCell(1);
		cell.setCellStyle(headStyle);
		cell.setCellValue("email");
		cell = row.createCell(2);
		cell.setCellStyle(headStyle);
		cell.setCellValue("nickname");
		cell = row.createCell(3);
		cell.setCellStyle(headStyle);
		cell.setCellValue("content");

		for(ChatVO data : datas) {

			row = sheet.createRow(rowNo++);
			cell = row.createCell(0);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.getCdatetime());
			cell = row.createCell(1);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.getEmail());
			cell = row.createCell(2);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.getNickname());
			cell = row.createCell(3);
			cell.setCellStyle(bodyStyle);
			cell.setCellValue(data.getContent());
		}
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);

		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition", "attachment;filename="+vo.getRpk()+"chatlog.xls");

		wb.write(response.getOutputStream());
		wb.close();
	}

}
