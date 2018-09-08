package org.protogalaxy.phss.component.file.music;



import static org.bytedeco.javacpp.avcodec.*;
import static org.bytedeco.javacpp.avformat.*;
import static org.bytedeco.javacpp.avutil.*;
import static org.bytedeco.javacpp.swscale.*;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.protogalaxy.phss.component.file.FileConsts;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

//TODO: Update to FFmpeg 4.0.0
@Component
public class MusicMetadata {

}
