package aqa.customelement.customdecorator;

import aqa.customelement.abstraction.IElement;
import org.openqa.selenium.WebElement;

class WrapperFactory {
    /**
     *      * Создает экземпляр класса,
     *      * реализующий IElement интерфейс,
     *      * вызывая конструктор с аргументом WebElement
     *
     */
    static IElement createInstance(Class<IElement> clazz,
                                   WebElement element) {
        try {
            return clazz.getConstructor(WebElement.class).
                    newInstance(element);
        } catch (Exception e) {
            throw new AssertionError("WebElement can't be represented as " + clazz
            );
        }
    }
}
