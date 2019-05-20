package com.imsystem.controller.promotion;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class StringFormula {

	public static void main(String[] args) {
		
		
		new StringFormula().condition();

		
	}
	
	public boolean condition() {
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        Compilable compilable = (Compilable) engine;
        Bindings bindings = engine.createBindings(); //Local级别的Binding
        String script = "F > 1"; //定义函数
        CompiledScript JSFunction = null; //解析编译脚本函数
        try {
            JSFunction = compilable.compile(script);
            bindings.put("F", 2.5);
            Object result = JSFunction.eval(bindings);
           return (boolean) result; //返回结果
        } catch (ScriptException e) {
            e.printStackTrace();
        }
		
        return false;
        
	}
	
	
}
