package com.example.copyclaudereference

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ide.CopyPasteManager
import java.awt.datatransfer.StringSelection

class CopyClaudeReferenceAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val editor = e.getData(CommonDataKeys.EDITOR) ?: return
        val project = e.project ?: return
        val file = e.getData(CommonDataKeys.VIRTUAL_FILE) ?: return

        val projectBasePath = project.basePath ?: return
        val relativePath = file.path.removePrefix(projectBasePath).removePrefix("/")

        val selectionModel = editor.selectionModel
        val document = editor.document

        val reference = if (selectionModel.hasSelection()) {
            val startLine = document.getLineNumber(selectionModel.selectionStart) + 1
            val endLine = document.getLineNumber(selectionModel.selectionEnd) + 1
            if (startLine == endLine) {
                "@$relativePath#L$startLine"
            } else {
                "@$relativePath#L$startLine-$endLine"
            }
        } else {
            val caretLine = document.getLineNumber(editor.caretModel.offset) + 1
            "@$relativePath#L$caretLine"
        }

        CopyPasteManager.getInstance().setContents(StringSelection(reference))
    }

    override fun update(e: AnActionEvent) {
        e.presentation.isEnabledAndVisible = e.getData(CommonDataKeys.EDITOR) != null
    }
}
