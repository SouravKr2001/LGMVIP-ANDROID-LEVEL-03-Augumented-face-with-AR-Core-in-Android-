package com.example.multifacefilter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;


public class SecondFilter extends AppCompatActivity {
    private ArFragment arFragment2;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_filter);

        arFragment2 = (ArFragment) ((Object)getSupportFragmentManager().findFragmentById(R.id.arFragment2));
        assert arFragment2 != null;
        arFragment2.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {

            Anchor anchor = hitResult.createAnchor();

            ModelRenderable.builder()
                    .setSource(this, Uri.parse("TocoToucan.sfb"))
                    .build()
                    .thenAccept(modelRenderable -> addModelToScene(anchor,modelRenderable));

        });
    }

    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable) {

        AnchorNode node = new AnchorNode(anchor);
        TransformableNode transformableNode = new TransformableNode(arFragment2.getTransformationSystem());
        transformableNode.setParent(node);
        transformableNode.setRenderable(modelRenderable);

        arFragment2.getArSceneView().getScene().addChild(node);
        transformableNode.select();
    }
}