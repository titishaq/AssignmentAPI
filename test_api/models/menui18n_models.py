from odoo import models, fields


class MenuI18N(models.Model):
    _name = 'my_custom_module.menu_i18n'
    _description = 'Menu Internationalization'

    menu_id = fields.Many2one('my_custom_module.menu', string='Menu', required=True)
    lang_code = fields.Many2one('my_custom_module.language', string='Language', required=True)
    menu_name = fields.Char(string='Menu Name')
    menu_desc = fields.Char(string='Menu Description')
    modified_by = fields.Char(string='Modified By')
    modified_at = fields.Datetime(string='Modified At', readonly=True, auto_now=True)