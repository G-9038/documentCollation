package club.laomile.controller;

import club.laomile.bean.QuestionBean;
import club.laomile.bean.UserBean;
import club.laomile.service.QuestionDeleteService;
import club.laomile.service.QuestionSelectService;
import club.laomile.utils.DownloadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class QuestionController {

    @Autowired
    QuestionSelectService qss;

    @Autowired
    QuestionDeleteService qds;


    @RequestMapping(value = "/question/select", method = RequestMethod.POST)
    public ModelAndView questionSelect(HttpSession session, @RequestParam("selectByquestion") String question, Model model) {
        UserBean ub = (UserBean) session.getAttribute("user");
        Integer file_user_id = ub.getUser_id();
        List<QuestionBean> list = qss.questionSelect(question,file_user_id);
        ModelAndView modelandview = new ModelAndView();
        modelandview.addObject("list", list);
        modelandview.setViewName("selectResult");
        return modelandview;
    }

    @RequestMapping(value = "toExcel")
    public void toExcel(HttpSession session,HttpServletRequest request, HttpServletResponse response, @RequestParam("uploadByquestion") String question) {
        UserBean ub = (UserBean) session.getAttribute("user");
        Integer file_user_id = ub.getUser_id();
        List<QuestionBean> list = qss.questionSelect(question,file_user_id);
        DownloadExcel.downExel(list,response);
    }


    @RequestMapping(value = "/question/delete",method = RequestMethod.POST)
    public ModelAndView questionDelete(@RequestParam("question_id") Integer questionId,HttpSession session){
        qds.questionDelete(questionId);
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("selectResult");
        return modelandview;
    }
}



