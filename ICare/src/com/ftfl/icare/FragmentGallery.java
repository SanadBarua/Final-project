package com.ftfl.icare;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;



public class FragmentGallery extends Fragment {
	List<String> mImagePathList = new ArrayList<String>();

	public FragmentGallery() {
		File mediaStorageDir = new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				ICareConstants.IMAGE_DIRECTORY_NAME);
		for (File imageFile : mediaStorageDir.listFiles()) {
			if (imageFile.isFile()) {
				mImagePathList.add(imageFile.getAbsolutePath());
			}
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.activity_gallery_view,
				container, false);

		GridView gridview = (GridView) view.findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(getActivity(), mImagePathList));

		return view;
	}
}
