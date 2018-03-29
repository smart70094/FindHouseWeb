

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pyhon.SpiderModel.FindHouseTemplate;
import com.pyhon.SpiderModel._591HouseTemplateImpl;
import com.strategy.FindHouseStrategy;
import com.strategy._591Strategy;

/**
 * Servlet implementation class HouseController
 */
@WebServlet("/HouseController")
public class HouseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FindHouseStrategy strategy=new _591Strategy();
		FindHouseTemplate spider=new _591HouseTemplateImpl();
		ArrayList<Map<String,String>> data;
		data=strategy.exec(spider);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
