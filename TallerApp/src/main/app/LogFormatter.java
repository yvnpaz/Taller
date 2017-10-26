package main.app;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter {

    private static final DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");

    @Override
    public synchronized String format(LogRecord record) {

	StringBuilder builder = new StringBuilder(1000);
	builder.append(df.format(new Date(record.getMillis()))).append(" - ");
	builder.append("[Thread: ").append(record.getThreadID()).append("] - ");
	if (record.getSourceMethodName().equals("filter"))
	    builder.append("{").append(record.getLoggerName()).append("} - ");
	else {
	    builder.append("{").append(record.getLoggerName()).append(".");
	    builder.append(record.getSourceMethodName()).append("} - ");
	}
	builder.append("[").append(record.getLevel()).append("] --> ");
	builder.append(formatMessage(record));
	builder.append("\n");

	String throwable = "";
	if (record.getThrown() != null) {
	    final StringWriter stringWriter = new StringWriter();
	    final PrintWriter printWriter = new PrintWriter(stringWriter);
	    record.getThrown().printStackTrace(printWriter);
	    throwable = stringWriter.toString();
	}

	builder.append(throwable);

	return builder.toString();
    }

}
