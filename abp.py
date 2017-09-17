def post_hackzurich(token, local_image_path=None, image_url=None):
  url = ''
	headers = {'Authorization' : 'Token {}'.format(token)
	data = {}
	files = {}
	if local_image_path is not None:
	  files = {'image' : pe
