package br.com.erudio.controller;


import br.com.erudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/math")
@RestController

public class MathController {

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{n1}/{n2}")
    public Double sum(
                @PathVariable("n1") String n1,
                @PathVariable("n2") String n2
        ) throws Exception{
            if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
            return convertToDouble(n1) + convertToDouble(n2);
        }

    @RequestMapping("/sub/{n1}/{n2}")
    public Double subtraction(
            @PathVariable("n1") String n1,
            @PathVariable("n2") String n2
    ) throws Exception{
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(n1) - convertToDouble(n2);
    }

    @RequestMapping("/mult/{n1}/{n2}")
    public Double multiplication (
            @PathVariable("n1") String n1,
            @PathVariable("n2") String n2
    ) throws Exception{
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(n1) * convertToDouble(n2);
    }

    @RequestMapping("/div/{n1}/{n2}")
    public Double Division(
            @PathVariable("n1") String n1,
            @PathVariable("n2") String n2
    ) throws Exception{
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Please set a Numeric value!");
        return convertToDouble(n1) / convertToDouble(n2);
    }

    @RequestMapping("/mean/{n1}/{n2}")
    public Double mean(
            @PathVariable("n1") String n1,
            @PathVariable("n2") String n2
    ) throws Exception{
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return (convertToDouble(n1) + convertToDouble(n2)) / 2;
    }

    @RequestMapping("/raiz/{n1}")
    public Double raiz(
            @PathVariable("n1") String n1
    ) throws Exception{
        if(!isNumeric(n1)) throw new UnsupportedMathOperationException("Please set a numeric value");
        return Math.pow(convertToDouble(n1), 0.5);
    }


    private Double convertToDouble(String strNumber) throws IllegalAccessException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number); //Metodo para trasformar String pra Double
    }

    private boolean isNumeric(String strNumber) {
            if(strNumber == null || strNumber.isEmpty()) return false;
            String number = strNumber.replace(",",".");

            //Esse "regex" passa um parametro do que será aceito. Por exemplo: números positivos e negativos
            //que iram de 0 á 9, poderam ser separados por "." e os proximos numeros também serão de 0 á 9

            return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    // http://localhost:8080/math/subtraction/3/5
    // http://localhost:8080/math/division/3/5
}
