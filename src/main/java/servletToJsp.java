/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
import javax.servlet.http.*;

public class servletToJsp extends HttpServlet {

    public void doGet (HttpServletRequest request,
		       HttpServletResponse response) {

	try {
	    // Set the attribute and Forward to hello.jsp
	    request.setAttribute ("servletName", "helloServletToJsp");
	    getServletConfig().getServletContext().getRequestDispatcher("/jsp/jsptoserv/hello.jsp").forward(request, response);
	} catch (Exception ex) {
	    ex.printStackTrace ();
	}
    }
}
