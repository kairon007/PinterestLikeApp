package com.dreamtale.pintrestlike.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.dreamtale.pintrestlike.data.ImageInfo;
import com.dreamtale.pintrestlike.utils.CacheManager;
import com.dreamtale.pintrestlike.utils.ImageDownloader;

public class ItemView extends ImageView
{
    private ImageInfo imageInfo = null;
    
    public ItemView(Context context)
    {
        super(context);
    }
    
    public ItemView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    
    public ItemView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }
    
    public ImageInfo getImageInfo()
    {
        return imageInfo;
    }

    public void setImageInfo(ImageInfo iamgeInfo)
    {
        this.imageInfo = iamgeInfo;
        
        Bitmap bmp = CacheManager.getInstance().getBitmap(iamgeInfo.getThumbUrl());
        if (null == bmp)
        {
            ImageDownloader downloader = new ImageDownloader(this);
            downloader.execute();
        }
        else
        {
            setImageBitmap(bmp);
        }
    }  
}
