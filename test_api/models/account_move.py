from odoo import models, fields


class Language(models.Model):
    _name = 'my_custom_module.language'
    _description = 'Language Entity'

    lang_code = fields.Char(string='Language Code', required=True)
    lang_name = fields.Char(string='Language Name')
    lang_desc = fields.Char(string='Language Description')
    status = fields.Boolean(string='Status')
    modified_by = fields.Char(string='Modified By')
    modified_at = fields.Datetime(string='Modified At', readonly=True, auto_now=True)

    def create_language(self, language_data):
        return self.create(language_data)

    def delete_language(self):
        self.unlink()
