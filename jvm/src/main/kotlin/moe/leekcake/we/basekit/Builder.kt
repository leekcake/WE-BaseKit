package moe.leekcake.we.basekit

import org.json.JSONObject
import java.io.File
import java.io.FileWriter
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets


class Builder(val project: Project, val moduleName: String) {
    fun build(outputDir: File) {
        outputDir.mkdirs()

        val result = JSONObject()
        result.put("warning", "It's machine generated by WE-BaseKit, Do not edit this file")
        result.put("file", "index.html")
        result.put("title", project.title)

        val general = JSONObject()
        general.put("supportsaudioprocessing", project.supportAudioProcessing)

        val properties = JSONObject()

        for((order, configure) in project.configures.withIndex()) {
            properties.put(configure.name, configure.save().put("order", order))
        }
        general.put("properties", properties)

        val localization = JSONObject()

        val langMap = HashMap<String, JSONObject>()
        for(_localization in project.localizations) {
            for(localizationData in _localization.datas) {
                if(!langMap.containsKey(localizationData.lang)) {
                    langMap[localizationData.lang] = JSONObject()
                }
                langMap[localizationData.lang]!!.put(_localization.name, localizationData.text)
            }
        }

        for(lang in langMap.keys) {
            localization.put(lang, langMap[lang])
        }

        general.put("localization", localization)

        result.put("general", general)

        val project = File(outputDir, "project.json")
        result.write(OutputStreamWriter(FileOutputStream(project), StandardCharsets.UTF_8)).close()

        val index = File(outputDir, "index.html")
        if( !index.exists() ) {
            index.writeText(
                "<html>\n" +
                        "<head>\n" +
                        "\n" +
                        "<style>\n" +
                        "html, body {\n" +
                        "  width:  100%;\n" +
                        "  height: 100%;\n" +
                        "  margin: 0px;\n" +
                        "  overflow:hidden;\n" +
                        "}\n" +
                        "#background {\n" +
                        "  position: absolute;\n" +
                        "  border:0;\n" +
                        "  left: 0;\n" +
                        "  top: 0;\n" +
                        "  width:  100%;\n" +
                        "  height: auto;\n" +
                        "  margin: 0px;\n" +
                        "  z-index: 0;\n" +
                        "}\n" +
                        "#mainCanvas {\n" +
                        "  position: absolute;\n" +
                        "  left: 0;\n" +
                        "  top: 0;\n" +
                        "  z-index: 1;\n" +
                        "  width:  100%;\n" +
                        "  height: auto;\n" +
                        "  margin: 0px;\n" +
                        "}\n" +
                        "</style>\n" +
                        "\n" +
                        "<script type=\"text/javascript\" src=\"js/kotlin.js\"></script>\n" +
                        "<script type=\"text/javascript\" src=\"js/WE-BaseKit-js.js\"></script>\n" +
                        "<script type=\"text/javascript\" src=\"js/${moduleName}Js.js\"></script>\n" +
                        "\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<img id=\"background\" />\n" +
                        "<canvas id=\"mainCanvas\" width=\"1280\" height=\"1024\"></canvas>\n" +
                        "</body>\n" +
                        "</html>"
            )
        }
    }
}