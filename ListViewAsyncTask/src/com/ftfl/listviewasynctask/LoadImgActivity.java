package com.ftfl.listviewasynctask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.ftfl.shuvo.imagelistload.R;

public class LoadImgActivity extends Activity {

	ProgressDialog pDialog;

	private String[] mImageURLArray = new String[] {
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg",
			"http://mississaugakids.com/images/mississauga%20sports%20summer%20camps.gif",
			"https://cnjschoolprogram.files.wordpress.com/2008/08/sports_editor.png",
			"http://static.squarespace.com/static/5210e4c8e4b0750ce7e69c4c/523efca9e4b00600a82f6d1c/523f038ee4b0f99c83f01429/1379861392181/tennis_02.gif",
			"http://www.scoolservices.com/wp-content/uploads/sportsvector-pack.jpg"
			};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_load_img);

		ListView listView = (ListView) this.findViewById(R.id.listView);
		ImageAdapter imageAdapter = new ImageAdapter(this, R.layout.imageitem,
				mImageURLArray);
		listView.setAdapter(imageAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.load_img, menu);
		return true;
	}

	private abstract class LoadImage extends AsyncTask<String, String, Bitmap> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(LoadImgActivity.this);
			pDialog.setMessage("Why connection is too poor? ....");
			pDialog.show();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
