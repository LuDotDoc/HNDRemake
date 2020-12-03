package Week08.Assessment;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week08.Assessment                          *
 *************************************************************************/

public class Level extends Application {

    public void start(Stage theStage)   {
        theStage.setTitle( "Canvas Example" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 800, 600 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill( Color.RED );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(2);
        Font theFont = Font.font( "Ariel", FontWeight.BOLD, 48 );
        gc.setFont( theFont );
        gc.fillText( "Sokoban!", 60, 50 );
        gc.strokeText( "Sokoban!", 60, 50 );

        Image warehouseKeeper = new Image ("Week08/Assessment/SokobanImages/WarehouseKeeper.png");

        gc.drawImage( warehouseKeeper, 180, 100 );

        theStage.show();
    }
}


                                                                           
