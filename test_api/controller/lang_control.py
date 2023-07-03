from odoo import http
from odoo.http import request


class LanguageController(http.Controller):

    @http.route('/api/languages', auth='public')
    def get_languages(self, **kwargs):
        languages = request.env['my_custom_module.language'].sudo().search([])
        return languages.read(['lang_code', 'lang_name','lang_desc', 'status', 'modified_at', 'modified_by'])

    @http.route('/api/languages', type='json', auth='public')
    def create_language(self, language_data, **kwargs):
        language = request.env['my_custom_module.language'].sudo().create_language(language_data)
        return language.read(['lang_code', 'lang_name','lang_desc', 'status', 'modified_at', 'modified_by'])

    @http.route('/api/languages', type='json', auth='public')
    def update_language(self, language_data, **kwargs):
        language = request.env['my_custom_module.language'].sudo().browse(language_data['lang_code'])
        language.write(language_data)
        return language.read(['lang_code', 'lang_name','lang_desc', 'status', 'modified_at', 'modified_by'])

    @http.route('/api/languages', type='json', auth='public')
    def delete_language(self, lang_code, **kwargs):
        language = request.env['my_custom_module.language'].sudo().browse(lang_code)
        language.delete_language()
        return True
