package widgets;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

import java.awt.image.BufferedImage;
import java.io.File;

public class ImageComparison {
    public  void saveImage (String expected, String actual,  String result) {
        String path = "C:\\Users\\Serghei\\IdeaProjects\\.org.caribank\\screenshots\\";
        // load the images to be compared
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources(path+"expected\\"+expected);
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources(path+"actual\\"+actual);

        // where to save the result (leave null if you want to see the result in the UI)
        File resultDestination = new File(path+"result\\"+result);

        //Create ImageComparison object for it.
        com.github.romankh3.image.comparison.ImageComparison imageComparison = new com.github.romankh3.image.comparison.ImageComparison( expectedImage, actualImage, resultDestination );

        //Can be used another constructor for it, without destination.
        new com.github.romankh3.image.comparison.ImageComparison(path+"expected\\"+expected, path+"actual\\"+actual);
        //or
        new com.github.romankh3.image.comparison.ImageComparison(expectedImage, actualImage);

        //Also can be configured BEFORE comparing next properties:

        //Threshold - it's the max distance between non-equal pixels. By default it's 5.
        imageComparison.setThreshold(5);
        imageComparison.getThreshold();

        //RectangleListWidth - Width of the line that is drawn in the rectangle. By default it's 1.
        imageComparison.setRectangleLineWidth(5);
        imageComparison.getRectangleLineWidth();

        //DifferenceRectangleFilling - Fill the inside the difference rectangles with a transparent fill. By default it's false and 20.0% opacity.
        imageComparison.setDifferenceRectangleFilling(true, 20.0);
        imageComparison.isFillDifferenceRectangles();
        imageComparison.getPercentOpacityDifferenceRectangles();

        //ExcludedRectangleFilling - Fill the inside the excluded rectangles with a transparent fill. By default it's false and 20.0% opacity.
        imageComparison.setExcludedRectangleFilling(true, 20.0);
        imageComparison.isFillExcludedRectangles();
        imageComparison.getPercentOpacityExcludedRectangles();

        //Destination. Before comparing also can be added destination file for result image.
        imageComparison.setDestination(resultDestination);
        imageComparison.getDestination();

        //MaximalRectangleCount - It means that would get first x biggest rectangles for drawing.
        // by default all the rectangles would be drawn.
        imageComparison.setMaximalRectangleCount(10);
        imageComparison.getMaximalRectangleCount();

        //MinimalRectangleSize - The number of the minimal rectangle size. Count as (width x height).
        // by default it's 1.
        imageComparison.setMinimalRectangleSize(1);
        imageComparison.getMinimalRectangleSize();

        //Change the level of the pixel tolerance:
        imageComparison.setPixelToleranceLevel(0.05);
        imageComparison.getPixelToleranceLevel();

        //After configuring the ImageComparison object, can be executed compare() method:
        ImageComparisonResult imageComparisonResult = imageComparison.compareImages();

        //Can be found ComparisonState.
        ImageComparisonState imageComparisonState = imageComparisonResult.getImageComparisonState();

        //And Result Image
        BufferedImage resultImage = imageComparisonResult.getResult();

        //Image can be saved after comparison, using ImageComparisonUtil.
        ImageComparisonUtil.saveImage(resultDestination, resultImage);
    }
}
