package tn.startupfactory.tunifund.interfaceM;

import java.io.File;
import com.example.mupdf.PDFHandler;
import tn.startupfactory.tunifund.R;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class PdfActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Creation PDF
		String titre="Donation to ";
		String ch1="From : ";
		String ch2="CIN : ";
		String ch3="Donation : ";
		String ch4="";
		String description[]=
				{ch1,
				 ch2 ,
				 ch3 //Max ligne
				,ch4};
		
		Bitmap courbe = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		Bitmap logo = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		String nameFile="pdfm";
		String nameDirectory="MesPDF";
		PDFHandler handler = new PDFHandler(nameFile,nameDirectory, logo, titre, description, courbe);
		handler.createPDF(getApplicationContext());
		
		///*****COnsultationPDF
		new PDFHandler().readPDF2(getApplicationContext(), "MesPDF", "pdfm");
		
		File dir = new File(Environment.getExternalStorageDirectory() + "/"+	"MesPDF");
    	File file = new File(dir,"pdfm"+".pdf");
    	if(file.exists()){
    		Log.d("tag", "exiiists");
    	}
    	Uri path = Uri.fromFile(file); 
        Intent intent = new Intent(Intent.ACTION_VIEW); 
        intent.setDataAndType(path, "application/pdf"); 
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
        
        try { 
        	getApplicationContext().startActivity(intent); 
        }  
        catch (ActivityNotFoundException e) { 
            Toast.makeText(getApplicationContext(),  
                "No Application Available to View PDF",  
                Toast.LENGTH_SHORT).show(); 
        } 
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pdf, menu);
		return true;
	}

}
