from odoo import http
from odoo.http import request
from odoo.exceptions import UserError
import json

class LanguageController(http.Controller):

    @http.route('/api/languages/create', type='json', auth='user')
    def create_language_action(self, **post):
        language = request.env['my_module.lang_entity']
        try:
            LanguageCode = post.get('LanguageCode')
            LanguangeDesc = post.get('LanguangeDesc')
            LanguangeName = post.get('LanguangeName')
            status = post.get('status')
            modifiedBy = post.get('modifiedBy')

            # Call the create_language method on the Language model
            language.create_language(LanguageCode, LanguangeDesc, LanguangeName, status, modifiedBy)

            return {'success': True, 'message': 'Language created successfully'}

        except Exception as e:
            error_message = str(e)
            return {'success': False, 'message': error_message}

    @http.route('/api/language/update', type='json', auth='user')
    def update_language_action(self, **post):
        language = request.env['my_module.lang_entity']
        try:
            LanguageCode = int(post.get('LanguageCode'))
            LanguangeDesc = post.get('LanguangeDesc')
            LanguangeName = post.get('LanguangeName')
            status = post.get('status')
            modifiedBy = post.get('modifiedBy')

            # Call the update_language method on the Language model
            language.update_language(LanguageCode, LanguangeDesc, LanguangeName, status, modifiedBy)

            return {'success': True, 'message': 'Language updated successfully'}

        except Exception as e:
            error_message = str(e)
            return {'success': False, 'message': error_message}

    @http.route('/api/language/delete', type='json', auth='user')
    def delete_language_action(self, **post):
        language = request.env['my_module.lang_entity']
        try:
            LanguageCode = int(post.get('LanguageCode'))

            # Call the delete_language method on the Language model
            language.delete_language(LanguageCode)

            return {'success': True, 'message': 'Language deleted successfully'}

        except Exception as e:
            error_message = str(e)
            return {'success': False, 'message': error_message}