/*
package springws.exam;

import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PythonExecController {
	private static PythonInterpreter pinterpreter;

	@RequestMapping(value = "/testpython", produces="text/html; charset=utf-8")
	public String getTest(int a, int b) {
		System.setProperty("python.import.site", "false");
		pinterpreter = new PythonInterpreter();
		pinterpreter.execfile("c:/Temp/test.py");
		pinterpreter.exec("print(testFunc(5,10))");

		PyFunction pyFuntion = (PyFunction) pinterpreter.get("testFunc", PyFunction.class);
		PyObject pyobj = pyFuntion.__call__(new PyInteger(a), new PyInteger(b));
		System.out.println(pyobj.toString());

		return "<h1>"+pyobj.toString()+"</h1>";
	}

}

*/
/*
 # test.py
def testFunc(a,b):
    print("TEST FUNC")
    c = a + b
    return c
*/
