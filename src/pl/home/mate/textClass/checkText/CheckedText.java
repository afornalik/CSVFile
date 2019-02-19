package pl.home.mate.textClass.checkText;



import pl.home.mate.textClass.checkText.checkTextPatternAttributeType.CheckOnePool;
import pl.home.mate.textClass.textIntefraces.CheckDataFormat;
import pl.home.mate.textFormatPatterns.preparedPatternsInterfaces.TextPatternType.TextPatternAcceptedAttributeType;

import java.util.Date;
import java.util.List;


public class CheckedText  implements CheckDataFormat {

    private List<String> textSplitList;
    private List<TextPatternAcceptedAttributeType> textPatternAcceptedAttributeTypes;


    public CheckedText(List<String> textSplitList, List<TextPatternAcceptedAttributeType> textPatternAcceptedAttributeTypes) {
        this.textSplitList = textSplitList;
        this.textPatternAcceptedAttributeTypes = textPatternAcceptedAttributeTypes;
    }

    @Override
    public boolean checkFormat()  {
        for (int i  = 0 ; i <textSplitList.size() ; i++) {
           if(!this.checkOnePool(this.textSplitList.get(i),this.textPatternAcceptedAttributeTypes.get(i))){
               return false;
           }
        }
        return true;
    }

    private boolean checkOnePool(String splitedText, TextPatternAcceptedAttributeType textPatternAcceptedAttributeType){
        CheckOnePool checkOnePool;

        if (textPatternAcceptedAttributeType.equals(TextPatternAcceptedAttributeType.STRING)){
             checkOnePool = new CheckOnePool<String>();
             checkOnePool.setNewt(new String());
             return checkOnePool.checkAttributeType(splitedText);

        }else if(textPatternAcceptedAttributeTypes.equals(TextPatternAcceptedAttributeType.INTEGER)) {
             checkOnePool = new CheckOnePool<Integer>();
             checkOnePool.setNewt(new Integer(4));
            return checkOnePool.checkAttributeType(splitedText);

        }else if(textPatternAcceptedAttributeTypes.equals(TextPatternAcceptedAttributeType.DATE)) {
            checkOnePool = new CheckOnePool<Date>();
            checkOnePool.setNewt(new Date());
           return  checkOnePool.checkAttributeType(splitedText);
        }
        return false;
    }




}
