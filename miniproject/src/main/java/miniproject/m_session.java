package miniproject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public class m_session {

    public static String check(HttpServletRequest req, Model m) {
        HttpSession ss = req.getSession(false); // 세션 없으면 null
        join_DTO dto = null;

        if (ss == null) {
            m.addAttribute("msg", "alert('로그인 후 이용 가능합니다.'); location.href='index.do';");
            return "load";
        } else {
            dto = (join_DTO) ss.getAttribute("dto");

            if (dto == null) {
                m.addAttribute("msg", "alert('로그인 후 이용 가능합니다.'); location.href='index.do';");
                return "load";
            }

            Long logtime = (Long) ss.getAttribute("logtime");
            if (logtime == null) {
                ss.invalidate();
                m.addAttribute("msg", "alert('세션이 만료되어 로그아웃 되었습니다.'); location.href='index.do';");
                return "load";
            }

            long now = System.currentTimeMillis();
            if (now - logtime > 30 * 60 * 1000) {
                ss.invalidate();
                m.addAttribute("msg", "alert('세션이 만료되어 로그아웃 되었습니다.'); location.href='index.do';");
                return "load";
            }
        }

        // 세션 이상 없음
        return null;
    }
}